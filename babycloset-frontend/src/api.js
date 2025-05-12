import axios from 'axios';

const API = {
  getWardrobeItems: () => axios.get('http://localhost:8081/api/wardrobe'),
  getItemsByCategory: (category) => axios.get(`http://localhost:8081/api/wardrobe/category/${category}`),
  getCategories: () => axios.get('http://localhost:8081/api/wardrobe/categories'),
  getLayetteItems: () => axios.get('http://localhost:8082/api/layette'),
  getExchangeItems: () => axios.get('http://localhost:8083/api/exchange')
};

export default API;

