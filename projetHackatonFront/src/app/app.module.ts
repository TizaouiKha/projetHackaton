import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccueilComponent, SafeHtmlPipe } from './components/accueil/accueil.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import {MatSidenavModule} from '@angular/material/sidenav';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {MatNavList} from '@angular/material/list';
import { SidebarToggleComponent } from './components/sidebar-toggle/sidebar-toggle.component';
import {MatButtonModule} from '@angular/material/button';



@NgModule({
  declarations: [
    AppComponent,
    SafeHtmlPipe,
    AccueilComponent,
    LoginComponent,
    SidebarToggleComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    MatSidenavModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatNavList,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
