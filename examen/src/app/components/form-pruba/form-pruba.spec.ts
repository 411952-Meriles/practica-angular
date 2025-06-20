import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormPruba } from './form-pruba';

describe('FormPruba', () => {
  let component: FormPruba;
  let fixture: ComponentFixture<FormPruba>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormPruba]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormPruba);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
