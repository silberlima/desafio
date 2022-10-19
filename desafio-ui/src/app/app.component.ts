import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  constructor(private http: HttpClient) {}

  onFileChange(event: any) {
    let headers = new HttpHeaders();
    headers.set('Content-Type', 'multipart/form-data');
    headers.set('mimeType', 'multipart/form-data');

    var formData: any = new FormData();
    for (var i = 0; i < event.target.files.length; i++) {
      formData.append('agente', formData);
    }

    this.http
      .post<any>('http://localhost:8080/arquivos', formData, {
        headers: headers,
      })
      .subscribe((res) => console.log(res));
  }
}
