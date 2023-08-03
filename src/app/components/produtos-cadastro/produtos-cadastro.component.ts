import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-produtos-cadastro',
  templateUrl: './produtos-cadastro.component.html',
  styleUrls: ['./produtos-cadastro.component.css']
})
export class ProdutosCadastroComponent {

  //variáveis
  mensagem: string = '';


  constructor(
    private httpClient : HttpClient
  ){
  
  }


  // criando a estrutura do formulário
  formCadastro = new FormGroup({
    //campo 'nome'
    nome: new FormControl('',
    [Validators.required, Validators.pattern(/^[A-Za-zÀ-Üà-ü0-9\s]{8,150}$/)]),
    
    //campo 'descricao'
    descricao: new FormControl('', 
    [Validators.required, Validators.pattern(/^[A-Za-zÀ-Üà-ü0-9\s]{8,500}$/)]),

    //campo 'preco'
    preco : new FormControl('', 
    [Validators.required, Validators.min(1)]),

    //campo 'quantidade'
    quantidade : new FormControl('', 
    [Validators.required, Validators.min(1)])
  });
    /*funcao para permitir as mensagens de erro e de validação na página
     em para cada campo do formulário
    */ 

  get form(): any{
    return this.formCadastro.controls
  }

  /* função para capturar o evento SUBMIT
  do formulário e mandar os dados para a API
  */

  onSubmit() : void{

    this.httpClient.post('http://localhost:8081/api/produtos', this.formCadastro.value)
      .subscribe({//capturando a resposta da API
        next:(data: any) => {
          //exibindo a mensagem na página
         this.mensagem = data.mensagem
         //limpando os campos do formulário
         this.formCadastro.reset();
        },
      error: (e) => { //recebendo a resposta de erro
        this.mensagem = e.mensagem;
        
      }
        
      })
  }
}
