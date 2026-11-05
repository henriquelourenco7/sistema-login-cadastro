import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  imports: [FormsModule, RouterLink],
  selector: 'app-login',
  styleUrl: './login.css',
  templateUrl: './login.html',
})
export class Login {
  
mensagem = 'Entre com seus dados para continuar';

email = '';
senha = '';

entrar() {
  if (!this.email || !this.senha) {
    alert('Preencha o e-mail e a senha.');
    return;
  }

  alert(`Email capturado: ${this.email}`);
}
}
