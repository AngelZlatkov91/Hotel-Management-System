import { EventEmitter, Component, Output } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
  })
export class LoginFormComponent {

  @Output() onSubmitLoginEvent = new EventEmitter();
  @Output() onSubmitRegisterEvent = new EventEmitter();

	active: string = "login";
  username: string = "";
  phone: string = "";
  email: string = "";
  age: number = 0;
  password: string = "";
  confirmPassword: string = "";

	onLoginTab(): void {
		this.active = "login";
	}

	onRegisterTab(): void {
		this.active = "register";
	}

  onSubmitLogin(): void {
    if (!this.email || !this.password ) {
      return;
    }
    this.onSubmitLoginEvent.emit({"email": this.email, "password": this.password});
  }

  onSubmitRegister(): void {
    if (this.password !== this.confirmPassword) {
      return;
    }
    this.onSubmitRegisterEvent.emit({
      "username": this.username,
       "phone": this.phone, 
       "email": this.email,
        "password": this.password ,
        "confirmPassword": this.confirmPassword,
        "age": this.age
    });
  }

}
