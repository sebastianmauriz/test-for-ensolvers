import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from '../Entity/Item';


export abstract class CommonService<E extends Item> {

  protected baseEndPoint!: string;

  protected header: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(protected http: HttpClient) { }

public listar(): Observable<E[]>{
  return this.http.get<E[]>(this.baseEndPoint);
}

public lisPage(page: string, size: string): Observable<any>{
  const params = new HttpParams()
  .set('page', page)
  .set('size', size);
  return this.http.get<any>(`${this.baseEndPoint}/paged`,{params: params})
}

public view(id: number): Observable<E>{
  return this.http.get<E>(this.baseEndPoint + '/' + id);
}

public save(e: E): Observable<E>{
  return this.http.post<E>(this.baseEndPoint, e,{headers: this.header});
}

public edit(e: E): Observable<E>{
  return this.http.put<E>(this.baseEndPoint + '/' + e.id, e,{headers: this.header});
  
}

public delete(id: number): Observable<void>{
  return this.http.delete<void>(this.baseEndPoint+ '/'+ id);
}

}
