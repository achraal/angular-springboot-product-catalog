import { Routes } from '@angular/router';
import { Home } from './home/home';
import { ProductsComponent } from './products/products';
import { NewProductComponent } from './new-product/new-product';
export const routes: Routes = [
  { path: 'home', component: Home },
  { path: 'products', component: ProductsComponent },
  { path: 'new-product', component: NewProductComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];
