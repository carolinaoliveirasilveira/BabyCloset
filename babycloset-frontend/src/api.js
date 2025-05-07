import axios from 'axios';

// Cria instâncias separadas para cada serviço, conforme as URLs definidas.
export const wardrobeApi = axios.create({
  baseURL: 'http://localhost:8081/api/wardrobe',
});

export const layetteApi = axios.create({
  baseURL: 'http://localhost:8082/api/layette',
});

export const exchangeApi = axios.create({
  baseURL: 'http://localhost:8083/api/exchange',
});
