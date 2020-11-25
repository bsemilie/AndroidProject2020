import { Test, TestingModule } from '@nestjs/testing';
import { CandyBarsController } from './candyBars.controller';
import { CandyBarsService } from './candyBars.service';

describe('AppController', () => {
  let appController: CandyBarsController;

  beforeEach(async () => {
    const app: TestingModule = await Test.createTestingModule({
      controllers: [CandyBarsController],
      providers: [CandyBarsService],
    }).compile();

    appController = app.get<CandyBarsController>(CandyBarsController);
  });

  describe('root', () => {
    it('should return "Hello World!"', () => {
      expect(appController.getHello()).toBe('Hello World!');
    });
  });
});
