import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { ProductService } from '../services/product';

@Component({
  selector: 'app-new-product',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './new-product.html',
  styleUrl: './new-product.css',
})
export class NewProductComponent {
  // Déclaration du formulaire réactif
  productForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private productService: ProductService,
    private router: Router,
  ) {
    // Initialisation du groupe de contrôles avec validations
    this.productForm = this.fb.group({
      name: ['', Validators.required],
      price: [0, [Validators.required, Validators.min(0)]],
      selected: [false],
    });
  }

  // Méthode de soumission du formulaire
  handleSaveProduct() {
    if (this.productForm.valid) {
      this.productService.saveProduct(this.productForm.value).subscribe({
        next: (data) => {
          alert('Produit enregistré avec succès !');
          this.router.navigateByUrl('/products');
        },
        error: (err) => console.error('Erreur lors de la sauvegarde:', err),
      });
    }
  }
}
