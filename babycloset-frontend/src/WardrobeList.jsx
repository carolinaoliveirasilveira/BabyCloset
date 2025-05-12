import { useEffect, useState } from 'react';
import API from './api';

function WardrobeList() {
  const [items, setItems] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState('');

  // Carregar todas as categorias ao iniciar
  useEffect(() => {
    API.getCategories()
      .then((res) => setCategories(res.data))
      .catch((err) => console.error('Erro ao buscar categorias:', err));
  }, []);

  // Carregar os itens ao iniciar ou ao mudar de categoria
  useEffect(() => {
    if (selectedCategory) {
      API.getItemsByCategory(selectedCategory)
        .then((res) => setItems(res.data))
        .catch((err) => {
          console.error('Erro ao filtrar por categoria:', err);
          setItems([]); // Evita erro na tela
        });
    } else {
      API.getWardrobeItems()
        .then((res) => setItems(res.data))
        .catch((err) => console.error('Erro ao buscar todos os itens:', err));
    }
  }, [selectedCategory]);

  return (
    <div style={{ marginBottom: '2rem' }}>
      <h2 style={{ fontSize: '1.5rem', marginBottom: '1rem' }}>🧸 Itens do Guarda-Roupa</h2>

      {/* Botões de categoria */}
      <div style={{ marginBottom: '1rem' }}>
        <button onClick={() => setSelectedCategory('')} style={buttonStyle}>
          Todos
        </button>
        {categories.map((cat) => (
          <button
            key={cat}
            onClick={() => setSelectedCategory(cat)}
            style={buttonStyle}
          >
            {cat}
          </button>
        ))}
      </div>

      {items.length === 0 ? (
        <p>👕 Nenhum item encontrado.</p>
      ) : (
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
              <span style={{ fontSize: '1.3rem' }}>👕</span>
              <span>
                <strong>{item.description}</strong> — Tamanho: <em>{item.size}</em> ({item.season})
              </span>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

const buttonStyle = {
  marginRight: '0.5rem',
  padding: '0.5rem 1rem',
  borderRadius: '8px',
  border: 'none',
  backgroundColor: '#87cefa',
  color: '#fff',
  cursor: 'pointer',
};

export default WardrobeList;
