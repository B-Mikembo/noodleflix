import { Component, Input, OnInit } from '@angular/core';
import { MovieModel } from './movie-model';
import { NgClass, NgStyle } from '@angular/common';

@Component({
  selector: 'app-movie',
  imports: [NgStyle, NgClass],
  templateUrl: './movie.html',
  styleUrl: './movie.css',
})
export class Movie implements OnInit {
  @Input() movie!: MovieModel;

  ngOnInit(): void {
    
  }
}
