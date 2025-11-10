import { Routes } from '@angular/router';
import { ClienteComponent } from './components/cliente/cliente.component';
export const routes: Routes = [

  {
    path: "clientes",
    component: ClienteComponent
  },

  {
    path: "",
    redirectTo: "clientes",
    pathMatch: "full"
  }
];
