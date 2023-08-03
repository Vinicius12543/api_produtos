import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { min } from 'rxjs';

@Component({
  selector: 'app-movimentacoes-cadastro',
  templateUrl: './movimentacoes-cadastro.component.html',
  styleUrls: ['./movimentacoes-cadastro.component.css']
})
export class MovimentacoesCadastroComponent {

  constructor(
    private httpClient: HttpClient
  ){
  }


  formCadastro = new FormGroup({
    idproduto: new FormControl('', [Validators.required]),
    tipo: new FormControl('', [Validators.required]),
    observacoes: new FormControl('', [Validators.required, Validators.minLength(8)]),
    quantidade: new FormControl('', [Validators.required, Validators.min(1)]),
    preco: new FormControl('', [Validators.required, Validators.min(1)]),
    dataMovimentacao: new FormControl('', [Validators.required])
  })

 produtos: any[] = [];


  ngOnInit(): void{
    this.httpClient.get('http://localhost:8081/api/produtos')
    .subscribe({
      next: (data) => {
      this.produtos = data as any[];

      },
      error:(e) =>{
        console.log(e)
      }
    })
  }

}
