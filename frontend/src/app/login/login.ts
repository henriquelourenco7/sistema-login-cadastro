import { Component, ChangeDetectorRef } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Auth } from '../services/auth';


@Component({
  imports: [FormsModule, RouterLink],
  selector: 'app-login',
  styleUrl: './login.css',
  templateUrl: './login.html',
})
export class Login {

  constructor(private auth: Auth,
    private cdr: ChangeDetectorRef) { }

  mensagem = 'Entre com seus dados para continuar';

  erroLogin = false;

  email = '';
  senha = '';

  entrar() {
    this.erroLogin = false;

    if (!this.email || !this.senha) {
      alert('Preencha o e-mail e a senha.');
      return;
    }

    this.auth.login(this.email, this.senha).subscribe({
      next: (resposta) => {
        console.log(resposta);
      },
      error: (erro) => {
        this.erroLogin = true;
        console.log('erroLogin:', this.erroLogin);
        this.mensagem = erro.error;
        console.log('mensagem:', this.mensagem);
        this.cdr.detectChanges();
      }
    });
  }
}
