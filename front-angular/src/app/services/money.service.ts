import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MoneyService {

  private ACCESS_KEY: string = "3b783ff82b42372ed56038a98763466c"

  constructor(private http: HttpClient) { }

  public USDToCOP(): Observable<any> {
    return this.http.get(`${environment.urlApiMoney}?access_key=${this.ACCESS_KEY}&currencies=COP&source=USD&format=1`);
  }
}
