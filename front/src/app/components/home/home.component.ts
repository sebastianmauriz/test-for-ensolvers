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

//    private activatedRoute:ActivatedRoute
  //item:Item = new Item;
  itemsArray:Item[]=[];
  selectItem:Item = new Item;
  itemToEdit!:Item;
  protected redirect!: string;
  constructor(
    private itemService: ItemService,
    private router: Router,) { }

  ngOnInit(): void {
    this.itemService.list().subscribe(items =>{
      this.itemsArray= items as Item[];
    })
    console.log(this.itemsArray);
  }

  public addItem(): void{
    this.itemService.save(this.selectItem).subscribe(it =>{
      this.itemsArray.push(it);
    })
    
  }

  public editItem(){
this.itemService.edit(this.itemToEdit).subscribe(it=>{
  this.itemsArray.push(it);
})
  }
  
}
