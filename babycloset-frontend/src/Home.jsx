import { useNavigate } from 'react-router-dom';

function Home() {
  const navigate = useNavigate();

  return (
    <div
      className="home-container"
      style={{
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        height: '100vh',
        textAlign: 'center',
        padding: '2rem',
      }}
    >
      <h1 style={{ fontSize: '2.5rem' }}>
        👶 Bem-vindos ao <strong>BabyCloset</strong>!
      </h1>
      <p style={{ fontSize: '1.2rem', marginBottom: '2rem' }}>
        Organize, acompanhe e gerencie tudo o que seu bebê precisa.
      </p>

      <div
        style={{
          display: 'flex',
          flexDirection: 'column',
          gap: '1rem',
          maxWidth: '300px',
          width: '100%',
        }}
      >
        <button onClick={() => navigate('/wardrobe')} style={btnStyle}>
          👕 Guarda-Roupa
        </button>
        <button onClick={() => navigate('/layette')} style={btnStyle}>
          🎀 Enxoval
        </button>
        <button onClick={() => navigate('/exchange')} style={btnStyle}>
          🔄 Trocas
        </button>
      </div>
    </div>
  );
}

const btnStyle = {
  padding: '1rem',
  fontSize: '1rem',
  borderRadius: '8px',
  border: 'none',
  cursor: 'pointer',
  backgroundColor: '#f5f5f5',
  transition: 'background-color 0.3s',
};

export default Home;
