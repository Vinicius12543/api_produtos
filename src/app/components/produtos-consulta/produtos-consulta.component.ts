import { Component } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-produtos-consulta',
  templateUrl: './produtos-consulta.component.html',
  styleUrls: ['./produtos-consulta.component.css']
})
export class ProdutosConsultaComponent {

  //variável
  produtos: any[] = [];

  constructor(
    private httpClient: HttpClient
  ){
  }

  ngOnInit(): void{
  
    this.httpClient.get('http://localhost:8081/api/produtos')
    .subscribe({
      next: (data) => {
        this.produtos = data as any[]
        console.log(this.produtos)
      },
      error: (e)=> {
        alert(e)
      }
      
    });
  
  }

}
