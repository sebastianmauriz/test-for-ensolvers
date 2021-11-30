import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BASE_ENDPOINT } from '../config/config';
import { Item } from '../Entity/Item';
import { CommonService } from './common.service';


@Injectable({
  providedIn: 'root'
})
export class ItemService extends CommonService<Item>{

  constructor(http: HttpClient) {
    super(http);
   }

   protected override baseEndPoint = BASE_ENDPOINT + '';

}
