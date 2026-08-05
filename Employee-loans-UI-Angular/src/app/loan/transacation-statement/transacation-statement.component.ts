import { formatDate } from '@angular/common';
import { Component } from '@angular/core';
import { EmployeeDataService } from '../../employee-data.service';
import { SharedModule } from '../../shared/shared.module';
import { Transaction } from './transaction.model';

@Component({
  selector: 'app-transacation-statement',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './transacation-statement.component.html',
  styleUrl: './transacation-statement.component.css'
})
export class TransacationStatementComponent {
transactions: Transaction[] = [];
  selectedDuration: string = ''; // default value or could be empty string
  startDate?: string;
  endDate?: string;

  ngOnInit() {
    this.loadTransactions();
  }

  constructor(private transactionService: EmployeeDataService) {}

  onDurationChange(duration: string): void {
    this.selectedDuration = duration;
    this.fetchTransactions();
  }



  id: string | null = '';
  
  fetchTransactions(): void {
    // The formatted dates should be `undefined` if not set, to prevent sending them to the backend
    const formattedStartDate = this.startDate ? formatDate(this.startDate, 'dd-MM-yyyy', 'en-US') : undefined;
    const formattedEndDate = this.endDate ? formatDate(this.endDate, 'dd-MM-yyyy', 'en-US') : undefined;
  
    // Check if custom dates are selected and clear the selectedDuration if they are
    if (formattedStartDate && formattedEndDate) {
    //  this.selectedDuration = undefined; // Now allowed since selectedDuration can be string or undefined
    }
  
    // Now pass the properly formatted dates or undefined to your service
    this.transactionService.getTransactions(this.id, this.selectedDuration, formattedStartDate, formattedEndDate)
      .subscribe(
        transactions => this.transactions = transactions,
        error => {
          console.error('There was an error retrieving the transactions', error);
        }
      );
  }
  
  
  

  onCustomDateChange(): void {
    if (this.startDate && this.endDate) {
      this.fetchTransactions();
    }
  }
  loadTransactions() {
    this.id = new URLSearchParams(window.location.search).get('id');
    if (!this.id) return;
    const formattedStart = this.startDate ? formatDate(this.startDate, 'dd-MM-yyyy', 'en-US') : undefined;
    const formattedEnd = this.endDate ? formatDate(this.endDate, 'dd-MM-yyyy', 'en-US') : undefined;
    this.transactionService.getTransactions(this.id, this.selectedDuration, formattedStart, formattedEnd)
      .subscribe({
        next: (data) => {
          this.transactions = data;
        },
        error: (err) => {
          console.error('There was an error retrieving the transactions', err);
        }
      });
  }
}
