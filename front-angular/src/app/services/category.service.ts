import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private rootUri: string = '/category';

  constructor(private http: HttpClient) { }

  public listAll(): Observable<any> {
    return this.http.get(environment.urlApi + this.rootUri);
  }

  public create( category: any ): Observable<any> {
    return this.http.post(environment.urlApi + this.rootUri, category);
  }
}
