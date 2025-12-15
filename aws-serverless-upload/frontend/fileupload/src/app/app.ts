import {Component, NgIterable, signal} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,CommonModule],
  templateUrl: './app.html',
  standalone: true,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('fileupload');
  selectedFile: any;
  loading: boolean | undefined;
  files: any[]= [];

  onFileSelected($event: Event) {

  }

  upload() {

  }

  download(file: any) {

  }
}
