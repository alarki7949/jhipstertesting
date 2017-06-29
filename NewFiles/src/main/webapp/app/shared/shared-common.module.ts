import { NgModule } from '@angular/core';
import { Title } from '@angular/platform-browser';

import {
    MyProjectSharedLibsModule,
    JhiAlertComponent,
    JhiAlertErrorComponent
} from './';

@NgModule({
    imports: [
        MyProjectSharedLibsModule
    ],
    declarations: [
        JhiAlertComponent,
        JhiAlertErrorComponent
    ],
    providers: [
        Title
    ],
    exports: [
        MyProjectSharedLibsModule,
        JhiAlertComponent,
        JhiAlertErrorComponent
    ]
})
export class MyProjectSharedCommonModule {}
