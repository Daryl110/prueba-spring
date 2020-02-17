import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private rootUri: string = '/product';

  constructor(private http: HttpClient) { }

  public listAll(): Observable<any> {
    return this.http.get(environment.urlApi + this.rootUri);
  }

  public create( category: any ): Observable<any> {
    return this.http.post(environment.urlApi + this.rootUri, category);
  }
}
