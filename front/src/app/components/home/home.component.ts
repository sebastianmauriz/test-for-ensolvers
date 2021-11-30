import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemService } from 'src/app/services/item.service';
import { Item } from 'src/app/Entity/Item';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

//private router: Router,    private activatedRoute:ActivatedRoute
  itemsArray:any[]=[];
  constructor(
    private itemService: ItemService) { }

  ngOnInit(): void {
    this.itemService.list().subscribe(items =>{
      this.itemsArray= items as Item[];
    })
    console.log(this.itemsArray);
  }

}
