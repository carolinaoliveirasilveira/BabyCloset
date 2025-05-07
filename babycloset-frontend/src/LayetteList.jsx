import { useEffect, useState } from 'react';
import API from './api';

function LayetteList() {
  const [items, setItems] = useState([]);

  useEffect(() => {
    API.getLayetteItems()
      .then((response) => setItems(response.data))
      .catch((error) => console.error('Erro ao carregar itens de enxoval:', error));
  }, []);

  if (items.length === 0) {
    return <p>🎀 Nenhum item de enxoval cadastrado.</p>;
  }

  return (
    <div>
      <h2>🎀 Itens do Enxoval</h2>
      <ul>
        {items.map((item) => (
          <li key={item.id}>{item.name} - {item.ageRange}</li>
        ))}
      </ul>
    </div>
  );
}

export default LayetteList;
