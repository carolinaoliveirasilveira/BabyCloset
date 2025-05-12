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
    <div style={{ marginBottom: '2rem' }}>
      <h2 style={{ fontSize: '1.5rem', marginBottom: '1rem' }}>🎀 Itens do Enxoval</h2>
      <ul style={{ listStyle: 'none', paddingLeft: 0 }}>
        {items.map((item) => (
          <li
            key={item.id}
            style={{
              backgroundColor: '#f0f8ff',
              marginBottom: '0.8rem',
              padding: '1rem',
              borderRadius: '12px',
              boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
              display: 'flex',
              alignItems: 'center',
              gap: '0.5rem'
            }}
          >
            <span style={{ fontSize: '1.3rem' }}>🎀</span>
            <span>
              <strong>{item.name}</strong> — Faixa etária: <em>{item.ageRange}</em>
            </span>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default LayetteList;
