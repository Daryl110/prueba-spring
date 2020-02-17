import { Component, OnInit, ViewChild } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import { DomSanitizer } from '@angular/platform-browser';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  public dataSource: MatTableDataSource<any>;
  public displayedColumns: string[];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private categoryService: CategoryService, private sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.displayedColumns = [ 'image', 'name', 'parent category' ];
    this.categoryService.listAll().subscribe(
      data => {
        this.dataSource = new MatTableDataSource(data);
        this.dataSource.paginator = this.paginator;
      }
    )
  }

  public transformImage( photo: any ) {
    return this.sanitizer.bypassSecurityTrustResourceUrl('data:image/png;base64,' + photo);
  }

}
