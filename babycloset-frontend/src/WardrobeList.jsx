import { useEffect, useState } from 'react';
import API from './api';

function WardrobeList() {
  const [items, setItems] = useState([]);

  useEffect(() => {
    API.getWardrobeItems()
      .then((response) => setItems(response.data))
      .catch((error) => console.error('Erro ao carregar itens do guarda-roupa:', error));
  }, []);

  if (items.length === 0) {
    return <p>👕 Nenhum item de guarda-roupa cadastrado.</p>;
  }

  return (
    <div>
      <h2>👕 Itens do Guarda-Roupa</h2>
      <ul>
        {items.map((item) => (
          <li key={item.id}>{item.name} - {item.ageRange}</li>
        ))}
      </ul>
    </div>
  );
}

export default WardrobeList;
