import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('frontend');


  mensagem = 'Entre com seus dados para continuar';
  email = '';
  senha = '';

  entrar(){
    if (!this.email || !this.senha){
      alert('Preencha o e-mail e a senha.')
      return;
    }
    alert(`Email capturado: ${this.email}`);
    
  }

  
  botaoDesabilitado = true;

}
