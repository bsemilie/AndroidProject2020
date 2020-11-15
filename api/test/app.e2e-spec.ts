import { Test, TestingModule } from '@nestjs/testing';
import { INestApplication } from '@nestjs/common';
import * as request from 'supertest';
import { AppModule } from './../src/app.module';
import supertest from "supertest";

describe('Chocolate Bars API', () => {
  let app: INestApplication;
  let httpRequester: supertest.SuperTest<supertest.Test>;

  beforeEach(async () => {
    const moduleFixture: TestingModule = await Test.createTestingModule({
      imports: [AppModule],
    }).compile();

    app = moduleFixture.createNestApplication();
    await app.init();

    httpRequester = request(app.getHttpServer());
  });

  it('/GET chocolateBars', async() => {
    const response =await httpRequester.get('/chocolateBars').expect(200);
    expect(response.body).toEqual(expect.any(Array));
  });

  it('POST chocolateBars', async() => {
    const response = await httpRequester.post('/chocolateBars').send({
      company: 'A.Morin',
      name: 'Chuao',
      date: '2013',
      cocoa_percent: '70',
      company_location: 'France',
      rating: '4',
      bean_origin: 'Venezuela',
      bean_type: 'Trinitario',
      ref: '1015',
    })
        .expect(201);
    expect(response.body).toEqual({
      company: 'A.Morin',
      name: 'Chuao',
      date: '2013',
      cocoa_percent: '70',
      company_location: 'France',
      rating: '4',
      bean_origin: 'Venezuela',
      bean_type: 'Trinitario',
      ref: '1015',
    });
  });

  it('/GET chocolateBars/:ref', async() => {
    await httpRequester.post('/chocolateBars').send({
      company: 'A.Morin',
      name: 'Chuao',
      date: '2013',
      cocoa_percent: '70',
      company_location: 'France',
      rating: '4',
      bean_origin: 'Venezuela',
      bean_type: 'Trinitario',
      ref: '1015',
    });

    const response = await httpRequester.get('/chocolateBars/1015').expect(200);

    expect(response.body).toEqual({
      company: 'A.Morin',
      name: 'Chuao',
      date: '2013',
      cocoa_percent: '70',
      company_location: 'France',
      rating: '4',
      bean_origin: 'Venezuela',
      bean_type: 'Trinitario',
      ref: '1015',
    });
  });

  it('/GET chocolate bars by company', async() => {
    await httpRequester.post('/chocolateBars').send({
      company: 'A.Morin',
      name: 'Chuao',
      date: '2013',
      cocoa_percent: '70',
      company_location: 'France',
      rating: '4',
      bean_origin: 'Venezuela',
      bean_type: 'Trinitario',
      ref: '1015',
    });
    await  httpRequester.post('/chocolateBars').send({
      company: 'Chocovic',
      name: 'Xoconusco',
      date: '2010',
      cocoa_percent: '71',
      company_location: 'Spain',
      rating: '3,25',
      bean_origin: 'Mexico',
      bean_type: 'Criollo',
      ref: '478',
    });
    await  httpRequester.post('/chocolateBars').send({
      company: 'Chocovic',
      name: 'Bolivar, Guaranda',
      date: '2007',
      cocoa_percent: '71',
      company_location: 'Spain',
      rating: '2,5',
      bean_origin: 'Ecuador',
      bean_type: 'Forastero (Arriba)',
      ref: '117',
    });

    const response = await  httpRequester
        .get('/chocolateBars')
        .query({company: 'Chocovic'})
        .expect(200);

    expect(response.body).toEqual([
      {
        company: 'Chocovic',
        name: 'Xoconusco',
        date: '2010',
        cocoa_percent: '71',
        company_location: 'Spain',
        rating: '3,25',
        bean_origin: 'Mexico',
        bean_type: 'Criollo',
        ref: '478',
      },
      {
        company: 'Chocovic',
        name: 'Bolivar, Guaranda',
        date: '2007',
        cocoa_percent: '71',
        company_location: 'Spain',
        rating: '2,5',
        bean_origin: 'Ecuador',
        bean_type: 'Forastero (Arriba)',
        ref: '117',
      },
    ]);
  });

  it('/DELETE chocolateBars/:ref', async() => {
    await httpRequester.post('/chocolateBars').send({
      company: 'Chocovic',
      name: 'Xoconusco',
      date: '2010',
      cocoa_percent: '71',
      company_location: 'Spain',
      rating: '3,25',
      bean_origin: 'Mexico',
      bean_type: 'Criollo',
      ref: '478',
    });

    await httpRequester.delete('/chocolateBars/478').expect(200);

    const response =await httpRequester.get('/chocolateBars');
    expect(response.body).toEqual([]);
  });
});
