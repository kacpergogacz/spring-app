import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FooterComponent} from './component/footer/footer.component';
import {HeaderComponent} from './component/header/header.component';
import {NavComponent} from './component/nav/nav.component';
import {MainComponent} from './component/main/main.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";

import {FormsModule} from "@angular/forms";
import {CompanyListComponent} from "./company/view/company-list/company-list.component";
import {HardwareListComponent} from "./hardware/view/hardware-list/hardware-list.component";
import {HardwareViewComponent} from "./hardware/view/hardware-view/hardware-view.component";
import {HardwareEditComponent} from "./hardware/view/hardware-edit/hardware-edit.component";
import {HardwareService} from "./hardware/service/hardware.service";
import {CompanyService} from "./company/service/company.service";
import {ErrorInterceptor} from "../error.interceptor";
import {CompanyEditComponent} from "./company/view/company-edit/company-edit.component";
import {CompanyViewComponent} from "./company/view/company-view/company-view.component";
import {HardwareAddComponent} from './hardware/view/hardware-add/hardware-add.component';
import {CompanyAddComponent} from './company/view/company-add/company-add.component';


@NgModule({
    declarations: [
        AppComponent,
        FooterComponent,
        HeaderComponent,
        NavComponent,
        MainComponent,
        CompanyListComponent,
        CompanyEditComponent,
        CompanyViewComponent,
        CompanyAddComponent,
        HardwareListComponent,
        HardwareViewComponent,
        HardwareEditComponent,
        HardwareAddComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule
    ],
    providers: [
        CompanyService,
        HardwareService,
        {
            provide: HTTP_INTERCEPTORS,
            useClass: ErrorInterceptor,
            multi: true
        }
    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule {

}
