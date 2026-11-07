import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private host: string = 'http://localhost:8083';

  constructor(private http: HttpClient) {}

  public getAllProducts(): Observable<any> {
    return this.http.get(`${this.host}/products`);
  }

  public deleteProduct(p: any): Observable<any> {
    return this.http.delete(`${this.host}/products/${p.id}`);
  }

  // 1. Ajouter un produit (POST)
  public saveProduct(product: any): Observable<any> {
    return this.http.post(`${this.host}/products`, product);
  }

  // 2. Basculer l'état selected (PATCH ou PUT)
  public toggleSelect(product: any): Observable<any> {
    return this.http.patch(`${this.host}/products/${product.id}`, {
      selected: !product.selected,
    });
  }
}
