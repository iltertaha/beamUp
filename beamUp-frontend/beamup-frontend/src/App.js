
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import BeamUp from './components/BeamUp';
import BeamMeUp from './components/BeamMeUp/BeamMeUp';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        
          <BrowserRouter>
          <Routes>
            <Route path="/" element={<BeamUp/>} />
            <Route path="/direct/:code" element={<BeamMeUp/>} />
          </Routes>
          
          </BrowserRouter>
      </header>
    </div>
  );
}

export default App;
