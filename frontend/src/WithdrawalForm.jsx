import { useState } from "react";
import { createWithdrawal } from "./api";

export default function WithdrawalForm({ onSuccess }) {
  const [productId, setProductId] = useState("");
  const [amount, setAmount] = useState("");
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(null);

  async function handleSubmit(e) {
    e.preventDefault();
    setError(null);
    setSuccess(null);
    try {
      const result = await createWithdrawal(Number(productId), Number(amount));
      setSuccess(`Withdrawal approved: R${result.amount}`);
      setProductId("");
      setAmount("");
      onSuccess();
    } catch (err) {
      setError(err.message);
    }
  }

  return (
    <div>
      <h2>New Withdrawal</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Product ID: </label>
          <input
            type="number"
            value={productId}
            onChange={(e) => setProductId(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Amount: </label>
          <input
            type="number"
            step="0.01"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            required
          />
        </div>
        <button type="submit">Submit Withdrawal</button>
      </form>
      {error && <p style={{ color: "red" }}>{error}</p>}
      {success && <p style={{ color: "green" }}>{success}</p>}
    </div>
  );
}