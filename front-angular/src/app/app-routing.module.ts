import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoryComponent } from './components/category/category.component';
import { CreateCategoryComponent } from './components/category/create-category/create-category.component';
import { ProductComponent } from './components/product/product.component';
import { CreateProductComponent } from './components/product/create-product/create-product.component';


const routes: Routes = [
  {
    path: 'categories',
    component: CategoryComponent
  },
  {
    path: 'create-category',
    component: CreateCategoryComponent
  },
  {
    path: 'category/:category/products',
    component: ProductComponent
  },
  {
    path: 'category/:category/products/create-product',
    component: CreateProductComponent
  },
  {
    path: '',
    component: CategoryComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
