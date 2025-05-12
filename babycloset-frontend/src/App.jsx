import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './Home';
import WardrobeList from './WardrobeList';
import LayetteList from './LayetteList';
import ExchangeList from './ExchangeList';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/wardrobe" element={<WardrobeList />} />
        <Route path="/layette" element={<LayetteList />} />
        <Route path="/exchange" element={<ExchangeList />} /> {/* placeholder */}
      </Routes>
    </Router>
  );
}

export default App;
