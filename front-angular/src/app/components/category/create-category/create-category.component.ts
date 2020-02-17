import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.css']
})
export class CreateCategoryComponent implements OnInit {

  public formGroup: FormGroup;
  public categories: any;

  constructor(private categoryService: CategoryService, private formBuilder: FormBuilder,
    private router: Router) { }

  ngOnInit(): void {
    this.builderForm();
  }

  private builderForm(): void {
    this.categoryService.listAll().subscribe(
      data => this.categories = data
    );
    this.formGroup = this.formBuilder.group({
      name: null,
      parentCategory: null,
      photo: null
    });
  }

  public uploadFile( event: any ): void {
    let fileReader: FileReader = new FileReader();
    let file = event.target.files[0];

    fileReader.readAsDataURL(file);

    fileReader.onload = () => {
      this.formGroup.get('photo').setValue(fileReader.result.toString().split(',')[1]);
    }
  }

  public createCategory(): void {
    this.categoryService.create(this.formGroup.value).subscribe(
      response => {
        if(response){
          window.history.back();
        }
      }
    );
  }

}
