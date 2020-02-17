import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ProductService } from 'src/app/services/product.service';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  public formGroup: FormGroup;
  public categories: any[] = [];

  constructor(private productService: ProductService, private categoryService: CategoryService, private formBuilder: FormBuilder,
    private router: Router) { }

  ngOnInit(): void {
    this.builderForm();
  }

  private builderForm(): void {
    this.categoryService.listAll().subscribe(
      data => {
        let dataArray: any[] = data;

        console.log(dataArray);
        
        for (let i = 0; i < dataArray.length; i++) {
          let flag: boolean = true;
          for (let j = i+1; j < dataArray.length; j++) {
            if(dataArray[j].parentCategory !== null && dataArray[i].id === dataArray[j].parentCategory.id){
              flag = false;
            }
          }
          if(flag){
            this.categories.push(dataArray[i]);
          }
        }
      }
    );
    this.formGroup = this.formBuilder.group({
      name: null,
      description: null,
      category: null,
      weight: null,
      price: null,
      photo1: null,
      photo2: null,
      photo3: null
    });
  }

  public uploadFile( event: any, photo: number): void {
    let fileReader: FileReader = new FileReader();
    let file = event.target.files[0];

    fileReader.readAsDataURL(file);

    fileReader.onload = () => {
      this.formGroup.get('photo' + photo).setValue(fileReader.result.toString().split(',')[1]);
    }
  }

  public createProduct(): void {
    this.productService.create(this.formGroup.value).subscribe(
      response => {
        if(response){
          window.history.back();
        }
      }
    );
  }

}
