import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { DomSanitizer } from '@angular/platform-browser';
import { ProductService } from 'src/app/services/product.service';
import { MoneyService } from 'src/app/services/money.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  public dataSource: MatTableDataSource<any>;
  public displayedColumns: string[];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private productService: ProductService, private moneyService: MoneyService, private sanitizer: DomSanitizer,
    private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.displayedColumns = [ 'image1', 'image2', 'image3', 'name', 'category', 'description', 'weight', 'price'];
    this.productService.listByCAtegory(this.activeRoute.snapshot.params.category).subscribe(
      data => {
        let dataArray: any[] = data;
        for (let i = 0; i < dataArray.length; i++) {
          this.moneyService.USDToCOP().subscribe(response => {
            dataArray[i].price = dataArray[i].price + ' USD - ' + (response.quotes.USDCOP * dataArray[i].price) + ' COP';
          });
        }
        this.dataSource = new MatTableDataSource(dataArray);
        this.dataSource.paginator = this.paginator;
      }
    )
  }

  public transformImage( photo: any ) {
    return this.sanitizer.bypassSecurityTrustResourceUrl('data:image/png;base64,' + photo);
  }
  
}
