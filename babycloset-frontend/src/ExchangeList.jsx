import { useEffect, useState } from 'react';
import API from './api';

function ExchangeList() {
  const [exchanges, setExchanges] = useState([]);

  useEffect(() => {
    API.getExchangeItems()
      .then((response) => {
        setExchanges(response.data);
      })
      .catch((error) => {
        console.error('Erro ao carregar trocas:', error);
      });
  }, []);

  if (exchanges.length === 0) {
    return <p>🔄 Nenhuma troca cadastrada.</p>;
  }

  return (
    <div style={{ padding: '2rem', maxWidth: '600px', margin: '0 auto' }}>
      <h2 style={{ textAlign: 'center' }}>🔄 Itens para Troca</h2>
      {exchanges.map((exchange) => (
        <div
          key={exchange.id}
          style={{
            border: '1px solid #ccc',
            borderRadius: '8px',
            padding: '1rem',
            marginBottom: '1rem',
            backgroundColor: '#f9f9f9',
          }}
        >
          <p><strong>👕 Nome:</strong> {exchange.itemName}</p>
          <p><strong>📝 Descrição:</strong> {exchange.description}</p>
          <p><strong>📦 Status:</strong> {exchange.status === 'AVAILABLE' ? 'Disponível' : 'Indisponível'}</p>
        </div>
      ))}
    </div>
  );
}

export default ExchangeList;

