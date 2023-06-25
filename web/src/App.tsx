import { useState } from 'react';
import './index.css';

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div className='bg-red-700'>
        <h1>React typescript setup complete</h1>
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.tsx</code> and save to test HMR
        </p>
      </div>
    </>
  )
}

export default App
