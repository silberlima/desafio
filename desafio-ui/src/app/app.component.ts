import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  constructor(private http: HttpClient) {}
  carregando = false;

  onFileChange(event: any) {
    this.carregando = true;
    let headers = new HttpHeaders();
    headers.set('Content-Type', 'multipart/form-data');
    headers.set('mimeType', 'multipart/form-data');

    var formData: any = new FormData();

    for (var i = 0; i < event.target.files.length; i++) {
      formData.append('arquivos', event.target.files[i]);
    }

    this.http
      .post<any>('http://localhost:8080/arquivos', formData)
      .subscribe((res) => {
        console.log(res);

      });

      setTimeout(()=>{
        this.carregando = false;
      }, 3000)
  }
}
