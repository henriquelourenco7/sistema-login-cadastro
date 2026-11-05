import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  imports: [FormsModule,RouterLink],
  selector: 'app-cadastro',
  styleUrl: './cadastro.css',
  templateUrl: './cadastro.html',
})
export class Cadastro {
  nome: string = '';
  email: string ='';
  senha: string = '';
  telefone: string = '';
  dataNascimento: string = '';

  cadastrar(){
    alert('Cadastro enviado');
  }
}
