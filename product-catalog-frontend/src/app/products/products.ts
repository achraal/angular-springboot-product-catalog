import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { ProductService } from '../services/product';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './products.html',
  styleUrl: './products.css',
})
export class ProductsComponent implements OnInit {
  products: any[] | null = null; // null indique l'état "chargement en cours"
  keyword: string = '';

  constructor(
    private productService: ProductService,
    private cdr: ChangeDetectorRef, // Injecter le détecteur de changement
  ) {}

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts() {
    this.productService.getAllProducts().subscribe({
      next: (data) => {
        console.log('Produits reçus du backend :', data);
        // Créer une nouvelle référence de tableau pour déclencher le Change Detection
        this.products = [...data];
        this.cdr.detectChanges(); // Forcer la mise à jour du DOM
      },
      error: (err) => {
        console.error('Erreur de chargement:', err);
        this.products = [];
        this.cdr.detectChanges();
      },
    });
  }

  handleToggleSelect(p: any) {
    this.productService.toggleSelect(p).subscribe({
      next: () => {
        p.selected = !p.selected;
        this.cdr.detectChanges();
      },
      error: (err) => console.error('Erreur lors du toggle:', err),
    });
  }

  handleDelete(p: any) {
    let conf = confirm('Voulez-vous vraiment supprimer ' + p.name + ' ?');
    if (conf) {
      this.productService.deleteProduct(p).subscribe({
        next: () => this.getProducts(),
        error: (err) => console.error('Erreur de suppression:', err),
      });
    }
  }

  get filteredProducts() {
    if (!this.products) return [];
    if (!this.keyword.trim()) return this.products;
    return this.products.filter((p: any) =>
      p.name?.toLowerCase().includes(this.keyword.toLowerCase()),
    );
  }
}
