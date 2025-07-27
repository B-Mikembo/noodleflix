import { Component, Input, OnInit } from '@angular/core';
import { MovieModel } from './movie-model';
import { NgClass, NgStyle } from '@angular/common';
import { Movie } from '../../domaines/movie/business/rules/entity/movie';

@Component({
  selector: 'app-movie',
  imports: [NgStyle, NgClass],
  templateUrl: './movie.html',
  styleUrl: './movie.css',
})
export class MovieComponent implements OnInit {
  @Input() movie!: Movie;

  ngOnInit(): void {
    
  }
}
