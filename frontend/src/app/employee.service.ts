import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import config from '../assets/config.json';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private backendUrl = config.backendUrl;

  constructor(private http: HttpClient) { 
    this.getConfigJson().subscribe((configJson) => {
      this.backendUrl = configJson.backendUrl;
    });
  }

  public getConfigJson(): Observable<any> {
    return this.http.get('./assets/config.json');
  }

  public getEmployees():Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.backendUrl}/employee/all`);
  }

  public addEmployee(employee: Employee):Observable<Employee> {
    return this.http.post<Employee>(`${this.backendUrl}/employee/add`, employee);
  }

  public updateEmployee(employee: Employee):Observable<Employee> {
    return this.http.put<Employee>(`${this.backendUrl}/employee/update`, employee);
  }

  public deleteEmployee(employeeId: number):Observable<void> {
    return this.http.delete<void>(`${this.backendUrl}/employee/delete/${employeeId}`);
  }
}
