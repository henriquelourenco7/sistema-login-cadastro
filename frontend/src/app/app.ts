import { Component } from '@angular/core';
import { Login } from './login/login';
import { Cadastro } from './cadastro/cadastro';

@Component({
  imports: [Login, Cadastro],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {}
