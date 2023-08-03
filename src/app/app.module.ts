import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";

import { ProdutosCadastroComponent } from './components/produtos-cadastro/produtos-cadastro.component';
import { ProdutosConsultaComponent } from './components/produtos-consulta/produtos-consulta.component';
import { ProdutosEdicaoComponent } from './components/produtos-edicao/produtos-edicao.component';
import { MovimentacoesCadastroComponent } from './components/movimentacoes-cadastro/movimentacoes-cadastro.component';
import { MovimentacoesConsultaComponent } from './components/movimentacoes-consulta/movimentacoes-consulta.component';
import { LoginComponent } from './components/login/login.component';
import { RecuperarSenhaComponent } from './components/recuperar-senha/recuperar-senha.component';
//mapear rotas para cada componente criado no projeto
const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo:'login' }, //página inicial do projeto

  { path: 'produtos-cadastro', component: ProdutosCadastroComponent },
  { path: 'produtos-consulta', component: ProdutosConsultaComponent },
  { path: 'produtos-edicao', component: ProdutosEdicaoComponent },
  { path: 'movimentacoes-cadastro', component: MovimentacoesCadastroComponent},
  { path: 'movimentacoes-consulta', component: MovimentacoesConsultaComponent},
  { path: 'login', component: LoginComponent },
  { path: 'recuperar-senha', component: RecuperarSenhaComponent }
];
@NgModule({
  declarations: [
    AppComponent,
    ProdutosCadastroComponent,
    ProdutosConsultaComponent,
    ProdutosEdicaoComponent,
    MovimentacoesCadastroComponent,
    MovimentacoesConsultaComponent,
    LoginComponent,
    RecuperarSenhaComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes), //registrando as rotas do projeto
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }