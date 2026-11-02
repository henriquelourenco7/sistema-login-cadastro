import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  imports: [RouterOutlet],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('frontend');

  entrar(){
    alert('botão entrar clicado!')
  }

  mensagem = 'Entre com seus dados para continuar';
  botaoDesabilitado = true;
  
}
